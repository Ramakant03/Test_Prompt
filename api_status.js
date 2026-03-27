//As an SDET, you receive an API response status code and need to classify it. Write a JavaScript program using a switch statement that takes an HTTP status code stored in a variable and prints the category and a QA-friendly message.
let statuscode = 401;
switch (statuscode) {
    case 1: console.log("200 → PASS - OK: Request successful");
    case 2: console.log("201 → PASS - Created: Resource created successfully");
    case 3: console.log("301 → WARNING - Moved Permanently: URL has changed");
    case 4: console.log("400 → FAIL - Bad Request: Check request payload");
    case 5: console.log("401 → FAIL - Unauthorized: Check auth token");
    case 6: console.log("403 → FAIL - Forbidden: Insufficient permissions");
    case 7: console.log("404 → FAIL - Not Found: Check endpoint URL");
    case 8: console.log("500 → FAIL - Internal Server Error: Backend issue");
    default: console.log("UNKNOWN - Unhandled status code");
}