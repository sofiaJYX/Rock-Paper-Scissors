# Rock-Paper-Scissors
A client-server application using TCP sockets, the client are able to play a game of “Rock-Paper-Scissors” with the server. 

## Developers
- Sofia Jia - yx881396@dal.ca
- Richuan Li - rc620706@dal.ca

## Environment Setup

#### Java Runtime Environment (JRE)

1. Make sure if you have JRE installed on your local computer. To check if you have JRE installed, open terminal and type command `java -version
   `. If it's not installed, the command won't be recognized. 
2. To download the JRE, you can visit the JRE website to download the latest version.

#### Preparing Server IP and Port

1. You will need your local server IP and port number to run this application. If you don't know those information, follow the below steps.
2. Find your server IP
- For Windows:
   - Open the Command Prompt by pressing the Windows key + R and type `cmd` in the Run box, then type `ipconfig`.
   - Search for the `IPv4 Address` in your result.
- For Mac OS:
  - Open the Terminal and type `ifconfig`.
  - Search for `inet` in your result.
- During your search, if contains multiple results, look for `en0` and you should be able to find your IP address.
3. Find your port number
- For Mac OS:
  - Open the Terminal and type `netstat -a`.
  - Search for either `127.0.0.1:port_number` or `localhost:port_number`.
- For Windows:
   - Open the Command Prompt by pressing the Windows key + R and type `cmd` in the Run box, then type `netstat -a`.
   - Search for the port number of your server in the `Local Address` column.

#### Now it's runtime!
1. If you don't see .class files in the application folder, do the following.
   - Open terminal/command prompt and type `javac main.java`, hit Enter and type `javac Server.java` and hit enter again.
   - Now you should be able to see .class files.
2. Open 2 separate terminal/command prompt.
3. In the first one, type `java Server [port number]` and enter. 
4. In the second one, type `java main [server ip] [port number]` and enter. (do not include `[]` in both commands!)
5. Now in your second terminal/command prompt, you should be able to play:)

     
