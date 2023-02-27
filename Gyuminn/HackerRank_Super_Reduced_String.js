// https://www.hackerrank.com/challenges/reduced-string/problem?isFullScreen=true

"use strict";

const fs = require("fs");

process.stdin.resume();
process.stdin.setEncoding("utf-8");

let inputString = "";
let currentLine = 0;

process.stdin.on("data", function (inputStdin) {
  inputString += inputStdin;
});

process.stdin.on("end", function () {
  inputString = inputString.split("\n");

  main();
});

function readLine() {
  return inputString[currentLine++];
}

/*
 * Complete the 'superReducedString' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

function superReducedString(s) {
  // recursive function
  const getReducedString = (s) => {
    if (!s) return "Empty String";

    for (let i = 0; i < s.length; i++) {
      if (s[i] === s[i + 1]) {
        return getReducedString(s.slice(0, i) + s.slice(i + 2));
      }
    }
    return s;
  };

  return getReducedString(s);
}

function main() {
  const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

  const s = readLine();

  const result = superReducedString(s);

  ws.write(result + "\n");

  ws.end();
}
