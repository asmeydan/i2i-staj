# ORACLE

Bu ödevde oracle kuracağız.  
Cloudda makinenin fiziksel sıkıntılarından dolayı localime kurdum.  
Ancak makinem mac olduğu için localimde de peeek çok sıkıntı yaşadım.  
Bu yüzden farklı bir sürümünü kurdum.  
![image](/homework11/imageOlusturma.png)
![image](/homework11/imageOlustu.png)

Bir şekilde çekmeyi başardığımız image mizden container olusturuyoruz.
![image](/homework11/containeriCalistirma.png)

Şimdi de containerın içine girip oracle'mizi test ediyoruz
![image](/homework11/oracleTest.png)

`docker run -d --name oracledb \
  -p 1521:1521 -p 5500:5500 \
  -e ORACLE_SID=ORCLCDB \
  -e ORACLE_PDB=ORCLPDB1 \
  -e ORACLE_PWD=oracle \
  oracle/database:19.3.0-ee
`