package test;

public interface UserInfoFactory<U extends UserInfo> {
	U create(Long userId,String username);
}
