public class ApacheUpload{
	public void upload{}{
		File tempDir = new File("D:/temp");
		if(!tempDir.exits()){
			tempDir.mkDir();
		}
		
		File saveDir = new File("D:/save");
		if(!saveDir.exits()){
			saveDir.mkDir();
		}
		
		if(ServletFileUpload.isMultipartContent(req)){
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024);
			factory.setRepository(tempDir);
			
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setSizeMax(1024*1024*6);
			
			List<FileItem> items = fileUpload.parseRequest(req);
			
			for(FileItem item : items){
				if(item.isFormField){
				}else{
					InputSteam in = items.getInputStream();
					String fileName = item.getName();
					String newFileName = UUID.randomUUID().toString()+fileName.substring(fileNmae.lastIndexOf("."));
					
					File file = new File(saveDir,newFileName);
					
					OutputStream out = new FileOutputStream(file);
					
					byte[] buffer = new byte[512];
					int len = -1;
					while((len = in.read(buffer)) != -1){
						out.write(buffer,0,len);
					}
					
					out.flush();
					out.close();
					in.close();
					
				}
			}
			
		} else{
		}
	}
}