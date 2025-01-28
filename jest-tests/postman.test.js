const fs = require('fs');
const path = require('path');
const { Collection } = require('postman-collection');
const axios = require('axios');

const collectionPath = path.resolve(__dirname, '../Postman/Locality_324.postman_collection.json');
const collectionJSON = JSON.parse(fs.readFileSync(collectionPath, 'utf-8'));
const collection = new Collection(collectionJSON);

const environmentVariables = {
  base_url: process.env.BASE_URL || 'http://localhost:8080/api/localities'
};

function replaceVariables(url) {
  return url.replace(/{{(.*?)}}/g, (match, varName) => {
    return environmentVariables[varName] || match;
  });
}

describe('Postman API Tests', () => {
  collection.items.each((item) => {
    test(`${item.name}`, async () => {
      if (item.request) {
        const request = item.request;
        let url = request.url.toString();
        url = replaceVariables(url);
        const method = request.method;

        const headers = {};
        if (request.headers) {
          request.headers.each((header) => {
            headers[header.key] = header.value;
          });
        }

        let data = null;
        if (request.body && request.body.mode === 'raw') {
          data = request.body.raw;
        }

        const options = {
          method,
          url,
          headers,
          data,
        };

        console.log(`Testing ${method} ${url} ...`);

        const response = await axios(options);

        expect(response.status).toBeGreaterThanOrEqual(200);
        expect(response.status).toBeLessThan(300);
      }
    });
  });
});
