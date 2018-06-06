package com.example.demo.exception;
/*测试枚举抛异常*/
public class main {

	public static void main(String[] args) throws Exception {
		System.out.println(SysErrorEnums.EMPTY_PARAME.getErrorCode()+","+SysErrorEnums.EMPTY_PARAME.getErrorMessage());
		System.out.println(DBServiceError.DB_SERVICE_NETWORK_ERROR.getCode()+","+DBServiceError.DB_SERVICE_NETWORK_ERROR.getMsg());
//		if(true){			
//			   throw new BusinessException(SysErrorEnums.EMPTY_PARAME);
//			}
		try{
			String a=null;
			System.out.println(a.equals("123"));
		}catch(Exception e){
			throw new BusinessException(SysErrorEnums.EMPTY_PARAME.getErrorCode(),SysErrorEnums.EMPTY_PARAME.getErrorMessage(),e);//手动抛异常是为了避免前端异常显示的太杂乱
		}
	}
	
}
