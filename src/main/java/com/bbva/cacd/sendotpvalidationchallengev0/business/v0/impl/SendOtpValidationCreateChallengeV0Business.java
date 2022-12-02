package com.bbva.cacd.sendotpvalidationchallengev0.business.v0.impl;

import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.ISendOtpValidationCreateChallengeV0Business;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.impl.SendOtpValidationCreateChallengeV0Dao;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoInCreateChallengePost;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoOutCreateChallengePost;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendOtpValidationCreateChallengeV0Business implements ISendOtpValidationCreateChallengeV0Business {

  private static final Log Log = LogFactory.getLog(SendOtpValidationCreateChallengeV0Business.class);
  @Autowired
  private SendOtpValidationCreateChallengeV0Dao dao;

  @Override
  public BDtoOutCreateChallengePost sendOtpValidationCreateChallengeV0(final BDtoInCreateChallengePost createChallengePost) {
    Log.debug(String.format("entrada business : ", createChallengePost));

    BDtoOutCreateChallengePost salida = dao.invokeRestlessApxTransaction(createChallengePost);
    //llamamos al metedo que retorna el BDtoOutCreateChallengePost y aqui le pasamos el parametro createChallengePost
    // para que nos haga la transformacion a BDtoOutCreateChallengePost

    Log.debug(String.format("salida Business: ", salida));
    return salida;
  }
}
