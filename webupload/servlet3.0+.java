
/*
����Ҫ�����Ϸ���@MultipartConfig��ע
*/


Part part = req.getPart("file");

//��ñ�name����
String name = part.getName();

//��ñ���mime����
String mimeType = part.getContentType();

//����ļ��Ĵ�С���˴�����ʹ��apache commons ��IO����е�
//FileUtils��byteCountToDisplaySize���������long������ֵת��Ϊ���Ķ����ļ���С
long size = part.getSize();

//����ϴ��ļ������֣�ע��˴���getSubmittedFileName����ֻ����tommcat8��ʹ��
String fileName = part.getSubmittedFileName();
//��ʹ��baidu��webuploaderʱ�����ʹ��String fileName = rq.getName()��������ļ����ϴ���


//��uuid�������ϴ����ļ����洢
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