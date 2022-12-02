package com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.impl;

import com.bbva.cacd.sendotpvalidationchallengev0.DummyMock;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.model.cceetl01_1.RequestTransactionCceetl01_1;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.model.cceetl01_1.ResponseTransactionCceetl01_1;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.tx.mapper.SendOtpValidationCreateChallengeV0DaoMapper;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoInCreateChallengePost;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoOutCreateChallengePost;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class SendOtpValidationCreateChallengeV0DaoTest {

    @InjectMocks
    private SendOtpValidationCreateChallengeV0Dao dao;
    //inyectamos los moscks a la clase simulada que queremos testear, es decir
    // todos las clases

    @Mock
    private ServicioTransacciones transaction;
    // simulamos solo clases este objeto, no toma el original

    @Mock
    private SendOtpValidationCreateChallengeV0DaoMapper mapeo;
    // simulamos solo clases este objeto, no toma el original

    private DummyMock dummyMock;

    @Before
    public void init(){
        dummyMock = new DummyMock();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void invokeRestlessApxTransactionTest(){
        Mockito.when(transaction.invocar(Mockito.any(), Mockito.any(), Mockito.any(RequestTransactionCceetl01_1.class))).thenReturn(dummyMock.getResponseDao());
        Mockito.when(mapeo.getResponse(Mockito.any(ResponseTransactionCceetl01_1.class))).thenReturn(dummyMock.getResponseDaoMapped());
        BDtoOutCreateChallengePost response = dao.invokeRestlessApxTransaction(dummyMock.getBDtoInCreateChallengePost());
        Assert.assertNotNull(response);
    }

    @Test
    public void test2(){
        //Define que cuando se ejecute el método getRequestTx se devolverá el resultado de  getRequestDao().
        Mockito.when(mapeo.getRequestTx(Mockito.any(BDtoInCreateChallengePost.class))).thenReturn(dummyMock.getRequestDao());
        Mockito.when(mapeo.getResponse(Mockito.any(ResponseTransactionCceetl01_1.class))).thenReturn(dummyMock.getBDtoOutCreateChallengePost());
    }
}
