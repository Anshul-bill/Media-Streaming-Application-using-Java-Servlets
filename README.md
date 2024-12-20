# Media-Streaming-Application-using-Java-Servlets
This project effectively demonstrates how to build a simple yet functional media streaming application using Java Servlets, focusing on both audio and video content delivery over a web interface.

# Components Used
1. Java Servlets:
   The main component for handling HTTP requests and responses, allowing for media file streaming.
2. File Handling:
   Utilizes FileInputStream to read audio and video files from the server's file system.
3. HTTP Protocol:
   The application primarily uses the HTTP protocol to transmit data between the server and clients. This is evident in the use of HttpServletRequest and HttpServletResponse.
4. Content Types:
   The servlet sets content types such as video/mp4 for video files and audio/mpeg for audio files, ensuring that browsers handle the streamed content correctly.
5. TCP (Transmission Control Protocol):
   Since HTTP operates over TCP, the streaming of media files in this application relies on TCP for reliable transmission of data packets.
