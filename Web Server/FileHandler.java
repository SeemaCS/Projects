

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileHandler {
	final static Pattern GETPATTERN = Pattern.compile("(GET) ([^ ]+) HTTP/(\\d\\.\\d)");
	final static Pattern HEADER = Pattern.compile("([^:]*):\\s*(.*)");
	private static final Map<String, String> mimeMap = new HashMap<String, String>() {{
		put("html", "text/html");
		put("css", "text/css");
		put("js", "application/js");
		put("jpg", "image/jpg");
		put("jpeg", "image/jpeg");
		put("png", "image/png");
	}};
	
	public File getFile(String input, DataOutputStream output, String documentRoot) {
		
		String requestType = input.substring(0, input.indexOf("/")-1);
		String file = input.substring(input.indexOf("/")+1, input.lastIndexOf("/")-5);
		if(file.equals(""))
			file = "index.html";	
		
		File returnedFile = new File(documentRoot+file);
		
		if(returnedFile.isDirectory()){
			File newFile = returnedFile.getAbsoluteFile();
			String path = input.substring(input.indexOf("/")+1, input.lastIndexOf("/")-5);
			if(newFile.exists())
				file = "index.html";
			returnedFile = new File(documentRoot+path+file);
		}
		return returnedFile;
	}
	
	public boolean getKeepAlive(Map<String, String> header, String version) {
        boolean connectionKeepAlive =
            header.containsKey("Connection") &&
            header.get("Connection").contains("keep-alive");
        boolean connectionClose =
            header.containsKey("Connection") &&
            header.get("Connection").contains("close");
        if
            ("1.0".equals(version) &&
             connectionKeepAlive
            ) 
        	return true; 
            if (("1.1".equals(version) &&
             !connectionClose))
             return true;
            else 
            	return false;
    }
	
	public Map<String, String> getHeader(BufferedReader reader) throws IOException {
		/*Map<String, String> header = new LinkedHashMap<String, String>();
        int length = 0;
            String inputRequest = reader.readLine();
            while(inputRequest != null) {
            length = inputRequest.length();
            if (length > 0) {
                Matcher matcher = HEADER.matcher(inputRequest);
                if (matcher.matches())
                    header.put(matcher.group(1), matcher.group(2).toLowerCase());
            }
           }
            return header;*/
		Map<String, String> headers = new LinkedHashMap<String, String>();

        int length = 0;
        do {
            String line = reader.readLine();
            if(line == null){
            	line = "";
            }
            length = line.length();
            if (length > 0) {
                Matcher matcher = HEADER.matcher(line);
                if (matcher.matches())
                    headers.put(matcher.group(1), matcher.group(2).toLowerCase());
                else
                    System.out.println("Skipping invalid header: '%s'"+ line);
            }
        } while (length > 0) ;

        return headers;
	}
	public boolean display(Socket clientSoc, String documentRoot, DataOutputStream output) {
		boolean keepAlive = false;
		try {
		final OutputStream out = clientSoc.getOutputStream();
	    final Writer writer = new OutputStreamWriter(out);
	    final InputStream in = clientSoc.getInputStream();
	    final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    byte[] fileBytes = null;
	    String error = "";
		
		String mime = "";
		String path = "";
		String input = "";
			String input1 = reader.readLine();
			if(input1 == null) {
				input1 = "";
			}
			Map<String, String> header = getHeader(reader);
			Matcher lineMatcher = GETPATTERN.matcher(input1);
        if (lineMatcher.matches()) {
            String requestType = lineMatcher.group(1);
            String fileType = lineMatcher.group(2);
            String version = lineMatcher.group(3);
        
        
        /*Map<String, String> header = new LinkedHashMap<String, String>();
        int length = 0;
            String inputRequest = reader.readLine();
            while(inputRequest != null) {
            length = inputRequest.length();
            if (length > 0) {
                Matcher matcher = GETPATTERN.matcher(inputRequest);
                if (matcher.matches())
                    header.put(matcher.group(1), matcher.group(2).toLowerCase());
            }
           }*/
        keepAlive = getKeepAlive(header, version);
        
        if(requestType.equals("GET")) {
        	if(version.equals("1.0") ||  version.equals("1.1")) {
        		//String requestType = input.substring(0, input.indexOf("/")-1);
        		String file = input1.substring(input1.indexOf("/")+1, input1.lastIndexOf("/")-5);
        		if(file.equals(""))
        			file = "index.html";	
        		 mime = file.substring(file.indexOf(".")+1);
        		File returnedFile = new File(documentRoot+file);
        		
        		if(returnedFile.isDirectory()){
        			File newFile = returnedFile.getAbsoluteFile();
        			path = input1.substring(input1.indexOf("/")+1, input1.lastIndexOf("/")-5);
        			if(newFile.exists())
        				file = "index.html";
        			mime = file.substring(file.indexOf(".")+1);
        			returnedFile = new File(documentRoot+path+file);
        		}
        		
				InputStream is;
				
					
					
						
					
				
						if(returnedFile.exists() && returnedFile.isFile()){
							if(returnedFile.canRead()) {
								is = new FileInputStream(documentRoot+path+file);
								fileBytes = new byte[is.available()];
								
								is.read(fileBytes);
								addHeader("200", mime, fileBytes.length, output, error);
								output.write(fileBytes);
							}
							else {
								error = "Permission Denied";
								fileBytes = "403 Forbidden".getBytes();
								addHeader("403", mime, error.length(), output, error);
								output.write(fileBytes);
							}
					
							//addHeader("200", mime, fileBytes.length, output, error);
						
						
						}
        	
						else {
							error = "File Not Found";
							fileBytes = error.getBytes();
							addHeader("404", "html", error.length(), output, error);	
							output.write(fileBytes);
						}
        	}
        	else {
        		error = "Bad Request";
        		fileBytes = error.getBytes();
				addHeader("400", "html", error.length(), output, error);
				output.write(fileBytes);
				
        	}
        }
        else {
        	error = "Bad Request";
        	fileBytes = error.getBytes();
			addHeader("400", "html", error.length(), output, error);
			output.write(fileBytes);
			
        }
		
        }
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return keepAlive;
	}
	
	private static void addHeader(String code, String mime, int length, DataOutputStream out, String message) throws Exception{
		out.writeBytes("HTTP/1.0 " + code + " OK\r\n");
		out.writeBytes("Content-Type: " + mimeMap.get(mime) + "\r\n");
		out.writeBytes("Content-Length: " + length + "\r\n"); 
		out.writeBytes("<html><title><body>"+message+"</body></title></html>");
		out.writeBytes("\r\n\r\n");
	}

}
