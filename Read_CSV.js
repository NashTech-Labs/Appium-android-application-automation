import { SharedArray } from "k6/data";
import http from "k6/http";
import papaparse from "https://jslib.k6.io/papaparse/5.1.1/index.js";
import encoding from 'k6/encoding';
import { check } from 'k6';
import { htmlReport } from "https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js";
import { textSummary } from 'https://jslib.k6.io/k6-summary/0.0.1/index.js';

// init
export function handleSummary(data) {
  return {
    "new3.html": htmlReport(data),
    'stdout': textSummary(data, { indent: ' ', enableColors: true }), // Show the text summary to stdout...

  };
}
//load test
export let options = {
  thresholds: {
    "http_req_duration": ["p(95)<1000"]
  },
  stages: [
    { duration: '5s', target: 50 }, // simulate ramp-up of traffic from 1 to 100 users over 5 minutes.
    { duration: '10s', target: 50 }, // stay at 100 users for 10 minutes.
    { duration: '5s', target: 0 }, // ramp-down to 0 users.
  ]
};
const csvRead = new SharedArray("credentials", function () {
  return papaparse.parse(open('./data.csv'), { header: true }).data; // returning array
});

export default function main() {

  var email = csvRead[Math.floor(Math.random() * csvRead.length)]['email'];
  var password = csvRead[Math.floor(Math.random() * csvRead.length)]['password'];

  // Generate base64 encoded credentials
  var toBeEncoded = email + ':' + password;
  var encodedString = encoding.b64encode(toBeEncoded);

  let params = {
    headers: {
      "Authorization": "Basic " + encodedString,
      "X-Requested-With": "XMLHttpRequest"
    }
  };

  let response = http.get("https://reqres.in/api/login", params);
  console.log(`Logging is using ` + email + ":" + password + ` Status: ` + response.status);
  check(response, {
    'status is 200 all thing are fine': (r) => r.status === 200,
  });
};