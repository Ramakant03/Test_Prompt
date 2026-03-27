// You receive an array of API response codes. Write code to:
//Check if ALL responses are successful (200–299)
//Find the FIRST non-success code
//Return all unique error codes
//let responses = [200, 201, 404, 500, 404, 200, 503];


function checkResponse(response) {
    if (response >= 200 && response <= 299) {
        console.log("Response is successful");
    } else {
        console.log("Response is not successful");
    }
}
let responses = [200, 201, 404, 500, 404, 200, 503];
for (let i = 0; i < responses.length; i++) {
    checkResponse(responses[i]);
}


let responses1 = [200, 201, 404, 500, 404, 200, 503];

// 1. Check if ALL responses are successful (200–299)
// We use the `every` method, which returns true only if ALL elements pass the test.
const allSuccessful = responses1.every(code => code >= 200 && code <= 299);

// 2. Find the FIRST non-success code
// We use the `find` method, which returns the first element that satisfies the condition.
const firstNonSuccess = responses1.find(code => code < 200 || code > 299);

// 3. Return all unique error codes
// First, we `filter` the array to get only the error codes.
// Then, we use a `Set` to remove duplicates and spread `...` it back into a new array.
const uniqueErrorCodes = [...new Set(responses.filter(code => code < 200 || code > 299))];

// Output the results
console.log("All successful:", allSuccessful);       // Output: false
console.log("First non-success:", firstNonSuccess);  // Output: 404
console.log("Unique errors:", uniqueErrorCodes);     // Output: [404, 500, 503]
