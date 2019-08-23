package com.Hasher;

public class Main {
	public static void main(String[] args){
		//instantiating the hasher object;
		Hasher hash = new Hasher();
		//password hash
		String password = "password";
		//try to parse in the variables, catch any exception if failed.
		try {
			//want to generate a hash, so the code will auto generate salt therefore null
			//set vHash to false to make as it isn't verifying the hash
			System.out.println(hash.generateHash(password, null, false));
		}catch(Exception e){
			//output error
			e.getMessage();
		}
		//salt entry of aGSdzkIPIDYAfoOseLQ0r4o2Q0Hd/bwSC2jtIB/17Qp3quA5PxCkPbVvm2MFa7nG2XaVycrphwvc4F5fRjo0opjmbcpfoBy2y8Y5uXQyOZAciYCPye/TJor43saVwG6cLJyE
		//should output a has of r9DcQQBFeCn/vwN7eiViJWayHQQuJ4djo+0e4oQAtjuZqoS9ixd5uEgBda0o9JTQnSpiJP99Jz7Il3ZCu/gf+URIsntTkbA2FD14LreyANBvr/R/FTOdCN2KISbXsuI9GHuJ2hxU7Fv2BJNthEiwvtqK/OZQ++/Yot3PVOKqgIhso6qzxMzZ0Gah
		//delete the comments to try the verify this ^^^^
		//try{
		//System.out.println(hash.generateHash(password,"aGSdzkIPIDYAfoOseLQ0r4o2Q0Hd/bwSC2jtIB/17Qp3quA5PxCkPbVvm2MFa7nG2XaVycrphwvc4F5fRjo0opjmbcpfoBy2y8Y5uXQyOZAciYCPye/TJor43saVwG6cLJyE".getBytes(), true));
		//}catch(Exception e){
		//e.getMessage();
		//}
	}
}