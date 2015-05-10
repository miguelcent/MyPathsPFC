<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@	page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%@	page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%	BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subir a Blobstore</title>
</head>
<body>
		<form action="<%=blobstoreService.createUploadUrl("/upload")%>" method="post" enctype="multipart/form-data">
			<label>Imagen para Ciclista</label>
			<input type="file" name="myFileCicl">
			<br>
			<label>Imagen para Gatronomica</label>
			<input type="file" name="myFileGastro">
			<br>
			<label>Imagen para Running</label>
			<input type="file" name="myFileRunning">
			<br>
			<label>Imagen para Senderismo</label>
			<input type="file" name="myFileSenderismo">
			<br>
			<label>Imagen para Turistico</label>
			<input type="file" name="myFileTuristico">
			<br>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>