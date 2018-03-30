public class DownLoad{

	public static void main(String[] args){

		String downName = req.getParameter("downName");
		String saveName = req.getParameter("saveName");
		
		File file = new File("saveDir",downName);
		
		InputStream in = new FileInputStream(file);
		
		//如果是下载需要加上此处判断
		if(SringUtils.isNotEmpty()){
			resp.setContentType(application/octet-stream);
			resp.addHeader("ContentDisposition","attachment;filename=\' + saveName+"\"");
			
		}
				
		OutputStream out = resp.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		int len = -1;
		while((len = in.read()) != -1){
			out.write(buffer,0,len);
		
		}
		
		out.flush();
		out.close();
		in.close();
			
	}

}