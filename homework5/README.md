# Hazelcast e nesne gönderme

ödev 3 te yaptığımız gibi hazelcast containerlarımızı kaldırıyoruz
(ancak hazelcastımızı dış dünyaya açabilmek için çalıştırırken ufak bir farklılık yapıyoruz)
![containerlar](/homework5/containerCalisiyor.png)

'docker run -d --name hazelcast-node -p 5701:5701 hazelcast/hazelcast:latest'
![localhost](/homework5/containeriDi%C5%9FDunya.png)

---

son olarak programımızı çalıştırıyoruz ve hazelcast imize nesnelerimizi gönderiyoruz
![hazelcast](/homework5/nesnelerEklendi.png)