#!/usr/bin/python      
#-*-coding:utf-8-*-      
       
# 进行表单提交  小项  2008-10-09
       
import json,httplib,urllib;  #加载模块    

TASKS_IDS=[]
REGION = 'hangzhou'
makeLinuxUrl = "/buildImage/make?key=key1&regionId="+REGION+"&imageId=1234&architecture=amd64&olLanguage=Chinese&platform=Centos&ossBucket=oss&sourceSystemOSSObject=/root/iso/centos68.iso&osType=linux&storageType=disk&storageCheckSum=f73c2c4dd333c202ca85ea66120cacdf&kvmEnabled=true&xenEnabled=false&systemDiskFormat=raw"
makeWinUrl = "/buildImage/make?key=key1&regionId="+REGION+"&imageId=1234&architecture=amd64&olLanguage=Chinese&platform=WindowsServer2012&ossBucket=oss&sourceSystemOSSObject=/root/iso/win-srv-2012-r2.iso&osType=windows&storageType=disk&storageCheckSum=5b5e08c490ad16b59b1d9fab0def883a&kvmEnabled=true&xenEnabled=false&systemDiskFormat=raw"

def testApiMake(makeUrl):
	#定义需要进行发送的数据
	params = urllib.urlencode({'key':'key1','regionId':'regionId','imageId':'imageId'});

	#定义一些文件头
	headers = {"Content-Type":"application/x-www-form-urlencoded",
	           "Connection":"Keep-Alive","Referer":"http://10.100.3.88:8080/buildImage/make"};
	#与网站构建一个连接
	conn = httplib.HTTPConnection("10.100.3.88:8080");
	#开始进行数据提交   同时也可以使用get进行
	conn.request(method="GET",url=makeUrl,headers=headers);

	#返回处理后的数据
	response = conn.getresponse()
	body = response.read()
	print body;
	jsonBody = json.loads(body)
	taskId = jsonBody['taskId']
	TASKS_IDS.append(taskId)
	print TASKS_IDS
	#关闭连接
	conn.close();


def testApiCheck(region):
	#定义需要进行发送的数据
	params = urllib.urlencode({'key':'key1','regionId':'regionId','imageId':'imageId'})

	#定义一些文件头
	headers = {"Content-Type":"application/x-www-form-urlencoded",
	           "Connection":"Keep-Alive","Referer":"http://10.100.3.88:8080/buildImage/check"};
	#与网站构建一个连接
	conn = httplib.HTTPConnection("10.100.3.88:8080");
	#开始进行数据提交   同时也可以使用get进行
	conn.request(method="GET",url="/buildImage/check?key=key1&regionId="+region+"&imageId=1234&action=check&architecture=i386&osType=linux&platform=Centos&targetImageFormat=raw&autoRepair=true&sourceImageOSSBucket=oss&sourceImageOSSObject=osb",headers=headers);
	#返回处理后的数据
	response = conn.getresponse();
	body = response.read();
	print body;
	jsonBody = json.loads(body);
	taskId = jsonBody['taskId']
	TASKS_IDS.append(taskId)
	print TASKS_IDS
	#关闭连接
	conn.close();


def testApiQueryTask(queryUrl):
	#定义需要进行发送的数据
	params = urllib.urlencode({'key':'key1','regionId':'regionId','imageId':'imageId'});

	#定义一些文件头
	headers = {"Content-Type":"application/x-www-form-urlencoded",
	           "Connection":"Keep-Alive","Referer":"http://10.100.3.88:8080/buildImage/image/task/query"};
	#与网站构建一个连接
	conn = httplib.HTTPConnection("10.100.3.88:8080");
	#开始进行数据提交   同时也可以使用get进行
	conn.request(method="GET",url=queryUrl,headers=headers);
	#返回处理后的数据
	response = conn.getresponse();
	print response.read();
	#关闭连接
	conn.close();

def testApiCancelTask(cancelUrl):
	#定义需要进行发送的数据
	params = urllib.urlencode({'key':'key1','regionId':'regionId','imageId':'imageId'});

	#定义一些文件头
	headers = {"Content-Type":"application/x-www-form-urlencoded",
	           "Connection":"Keep-Alive","Referer":"http://10.100.3.88:8080/buildImage/image/task/cancel"};
	#与网站构建一个连接
	conn = httplib.HTTPConnection("10.100.3.88:8080")
	#开始进行数据提交   同时也可以使用get进行
	conn.request(method="GET",url=cancelUrl,headers=headers)
	#返回处理后的数据
	response = conn.getresponse()
	body = response.read()
	print body
	#关闭连接
	conn.close()

if __name__ == '__main__':
    testApiMake(makeLinuxUrl);
    testApiMake(makeWinUrl);
    # testApiCheck(REGION)
    # print REGION
    # print TASKS_IDS
    # querUrl = "/buildImage/image/task/query?key=key1&pageNumber=1&pageSize=10&regionId="+REGION+"&taskIds="+",".join(TASKS_IDS)
    # print querUrl
    # testApiQueryTask(querUrl)
    # cancelUrl = "/buildImage/image/task/cancel?key=key1&regionId="+REGION+"&taskIds="+",".join(TASKS_IDS)
    # testApiCancelTask(cancelUrl)
