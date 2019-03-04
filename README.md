# HatchingHealth_ClipRx
Hatching health hackathon project to create a smart blisterpack.
Once a blisterpack is popped, we send an sms message notifying the careprovider which pack with poped and when.

# Arduino Javascript
npm install twilio to get twilio node modules

to run, enter either of the command below 
`screen ~/../../dev/tty.usb<serial or modem> 9600` to view output from Arduino
`ctrl+a then shift+h` to save output to logfile
`tail -f screenlog.0 | ./blister_pack_stream.js` to enable script

testing the script
`sh test_output.sh > output.log | tail -f output.log | ./blister_pack_stream.js`

# Med_Adhere (Original Name)
Springboot rest controller to send twilio messages for interacting with smart blisterpack.

Payload was different than final product, hence inconsistent naming. 

Run with 
`mvn spring-boot:run`, interact using REST api calls to localhost:8000