#!/usr/bin/env node
const accountSid = 'ACXXXXXXXX';
const authToken = '<auth token>';
const client = require('twilio')(accountSid, authToken);
const encoding = 'utf-8';

function getCurrentDateTimeString() {
    const date = new Date();
    return date.getFullYear() + '-' +
        (date.getMonth() + 1).toString().padStart(2, '0') + '-' +
        date.getDate().toString().padStart(2, '0') + ':' +
        date.getHours().toString().padStart(2, '0') + ':' +
        date.getMinutes().toString().padStart(2, '0') + ':' +
        date.getSeconds().toString().padStart(2, '0');
}

let data = new Set();
let dateMap = {};

dateMap[13] = "Monday Morning"
dateMap[12] = "Monday Noon"
// dateMap[11] = "Monday Evening"
// dateMap[10] = "Monday Bedtime"

process.stdin.setEncoding(encoding);
process.stdin.on('readable', function() {
    let chunk;
    while (chunk = process.stdin.read()) {
        chunk = chunk.replace(/\r\n$/, '')
        console.log("Received value: " + chunk)
        if (!data.has(chunk) 
        && String(chunk) in dateMap
        ) {
            data.add(chunk);
            console.log("Corresponding timeslot: " + dateMap[String(chunk)]);
            client.messages
                .create({
                    body: "Grandma's " + dateMap[String(chunk)] + " blisterpack pod was just popped at " + getCurrentDateTimeString(),
                    from: '+1<phone number from twilio>',
                    to: '+1<phone number to send to>'
                })
                .then(message => console.log(message.sid));
            console.info(data)
        }
    }
})

// to run, enter either of the command below 
// screen ~/../../dev/tty.usbmodem1411 9600 to view output from Arduino
// ctrl+a then shift+h to save output to logfile
// tail -f screenlog.0 | ./blister_pack_stream.js to enable script

// testing
// sh test_output.sh > output.log | tail -f output.log | ./blister_pack_stream.js


