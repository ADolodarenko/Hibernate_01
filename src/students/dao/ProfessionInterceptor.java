/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.dao;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * @author dolodarenko
 */
public class ProfessionInterceptor implements MethodInterceptor
{

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("Before: invocation=[" + mi + "]");
        Object rval = mi.proceed();
        System.out.println("Invocation returned");
        return rval;
    }
}
