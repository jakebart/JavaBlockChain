import java.util.Date;
import java.security.MessageDigest;

@FunctionalInterface
interface HashFunction {
    int hash(String key);
}

public class HasherDasher {
	public String hash;
	private static final int difficultyOfHash = 1;
	private String prev, data;
	public HasherDasher(String prev, String data) {
		this.hash = hashFunc(prev, data);//hashFunc(hKey).toString();
		this.prev = prev;
		this.data = data;
	}
	private String hashFunc(String prev, String data) {
		//Shout-out some SHA tutorial #No-P8-gang
		try {
			String stringToHash = prev + data + Long.toString(new Date().getTime());
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        
			//Applies sha256 to our input, 
			byte[] hash = digest.digest(stringToHash.getBytes("UTF-8"));
	        
			StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString(); 
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	protected void mineBlock() {
		String target = new String(new char[difficultyOfHash]).replace('\0', '0');
		System.out.println("Target: " + target);
		while(!hash.substring(0, difficultyOfHash).equals(target)) {
			hash = hashFunc(prev, data);
			System.out.println("Trying hash: " + hash);
		}
		System.out.println("successful mine m8");
	}
	private HashFunction hashFunc(String hKey) {
	//	@Override
		return new HashFunction() {
			public int hash(String key) {
				int ret = key.hashCode();
				return Math.abs(ret);
			}
        	
        };
	}
}
