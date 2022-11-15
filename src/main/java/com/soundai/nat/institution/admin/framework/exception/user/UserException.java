package com.soundai.nat.institution.admin.framework.exception.user;

import com.soundai.nat.institution.admin.framework.exception.BaseException;

/**
 * 用户信息异常类
 * 
 * @author soundai
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
