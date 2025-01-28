const fs = require('fs');
const path = require('path');
const { Collection } = require('postman-collection');
const axios = require('axios');

// Load Postman collection JSON
const collectionPath = path.resolve(__dirname, '../Postman/Locality_324.postman_collection.json');
const collectionJSON = JSON.parse(fs.readFileSync(collectionPath, 'utf-8'));
const collection = new Collection(collectionJSON);

describe('Postman API Tests', () => {
  collection.items.forEach((item) => {
    test(`${item.name}`, async () => {
      if (item.request) {
        const request = item.request;
        const url = request.url.toString();
        const method = request.method;

        // Build headers safely
        const headers = {};
        if (request.headers) {
          request.headers.each((header) => {
            headers[header.key] = header.value;
          });
        }

        // Get request body (if exists)
        let data = null;
        if (request.body && request.body.mode === 'raw') {
          data = request.body.raw;
        }

        // API Request options
        const options = {
          method,
          url,
          headers,
          data,
        };

        console.log(`Testing ${method} ${url} ...`);

        // Execute API request
        const response = await axios(options);

        // Validate response status
        expect(response.status).toBeGreaterThanOrEqual(200);
        expect(response.status).toBeLessThan(300);
      }
    });
  });
});
