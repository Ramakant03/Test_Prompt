//As an SDET, you receive an API response status code and need to classify it. Write a JavaScript program using a switch statement that takes an HTTP status code stored in a variable and prints the category and a QA-friendly message.
let statuscode = 401;
switch (statuscode) {
    case 200: console.log("PASS - OK: Request successful");
    case 201: console.log("PASS - Created: Resource created successfully");
    case 301: console.log("WARNING - Moved Permanently: URL has changed");
    case 400: console.log("FAIL - Bad Request: Check request payload");
    case 401: console.log("FAIL - Unauthorized: Check auth token");
    case 403: console.log("FAIL - Forbidden: Insufficient permissions");
    case 404: console.log("FAIL - Not Found: Check endpoint URL");
    case 500: console.log("FAIL - Internal Server Error: Backend issue");
    default: console.log("UNKNOWN - Unhandled status code");
}