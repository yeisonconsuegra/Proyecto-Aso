package com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.impl;

import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.ISendOtpValidationCreateChallengeV0Dao;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.model.cceetl01_1.RequestTransactionCceetl01_1;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.model.cceetl01_1.ResponseTransactionCceetl01_1;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.tx.mapper.SendOtpValidationCreateChallengeV0DaoMapper;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoInCreateChallengePost;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoOutCreateChallengePost;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.impl.SendOtpValidationCreateChallengeV0Business;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Component
public class SendOtpValidationCreateChallengeV0Dao implements ISendOtpValidationCreateChallengeV0Dao {

    private static final Log Log = LogFactory.getLog(SendOtpValidationCreateChallengeV0Business.class);
    @Autowired
    private ServicioTransacciones transactionService;

    @Autowired
    private SendOtpValidationCreateChallengeV0DaoMapper mapper;

    @Override
    public BDtoOutCreateChallengePost invokeRestlessApxTransaction(BDtoInCreateChallengePost bDtoInCreateChallengePost) {

        Log.debug(String.format("DAO: ", bDtoInCreateChallengePost));
        RequestTransactionCceetl01_1 apx = mapper.getRequestTx(bDtoInCreateChallengePost);
        // aqui hace un mapeo y retorna un objeto de tipo RequestTransactionCceetl01_1

        ResponseTransactionCceetl01_1 response = transactionService.invocar(RequestTransactionCceetl01_1.class, ResponseTransactionCceetl01_1.class, apx);
        Log.debug(String.format("Response : ", response));
        BDtoOutCreateChallengePost bDtoOutCreateChallengePost = mapper.getResponse(response);
        //aqui hace un mapeo y toma como parametro una transaccion de tipo ResponseTransactionCceetl01_1
        //y luego la transforma a BDtoOutCreateChallengePost para que el valor sea retornado

        Log.debug(String.format("bDtoOutCreateChallengePost return : ", bDtoOutCreateChallengePost));

        return bDtoOutCreateChallengePost;
        //se retorna el valor y lo enviamos al impl del business
    }

}
