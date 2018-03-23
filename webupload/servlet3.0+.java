
/*
首先要在类上方用@MultipartConfig标注
*/


Part part = req.getPart("file");

//获得表单name属性
String name = part.getName();

//获得表单的mime类型
String mimeType = part.getContentType();

//获得文件的大小，此处可以使用apache commons 的IO类库中的
//FileUtils的byteCountToDisplaySize方法将这个long类型数值转换为可阅读的文件大小
long size = part.getSize();

//获得上传文件的名字，注意此处的getSubmittedFileName方法只能在tommcat8中使用
String fileName = part.getSubmittedFileName();
//在使用baidu的webuploader时候可以使用String fileName = rq.getName()方法获得文件的上传名


//用uuid重命名上传的文件并存储
String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));

File saveDir = new File("savePath");
if(!saveDir.exits()){
	saveDir.mkdir();
}

InputStream in = part.getInputStream();

OutputStream out = new FileOutputStream(new File(saveDir,newFileName));

byte[] buffer = new byte[512];

int len = -1;
while((len = in.read(buffer)) != -1 ){
	out.write(buffer,0,len);
}

out.flush();
out.close();
in.close();