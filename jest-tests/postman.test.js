jobs:
  build-and-test:
    runs-on: ubuntu-latest

    steps:
      - name: Check out code
        uses: actions/checkout@v3

      - name: Set up JDK
        uses: actions/setup-java@v3
        with:
          distribution: 'temurin'
          java-version: '23'

      - name: Cache Gradle dependencies
        uses: actions/cache@v3
        with:
          path: ~/.gradle/caches
          key: ${{ runner.os }}-gradle-${{ hashFiles('**/*.gradle*', '**/gradle-wrapper.properties') }}
          restore-keys: |
            ${{ runner.os }}-gradle

      - name: Grant execute permissions for Gradle Wrapper
        run: chmod +x ./Code/gradlew

      - name: Build with Gradle
        run: ./gradlew build
        working-directory: ./Code

      - name: Start Spring Boot Application
        run: ./gradlew bootRun &
        working-directory: ./Code

      - name: Wait for API to be ready
        run: sleep 15  # Wait 15 seconds for the backend to start

      - name: Set up Node.js
        uses: actions/setup-node@v3
        with:
          node-version: '18'

      - name: Install npm dependencies
        run: npm install

      - name: Run Postman Tests with Jest
        run: npm run test:postman
