package com.bbva.cacd.sendotpvalidationchallengev0.business.v0.impl;

import com.bbva.cacd.sendotpvalidationchallengev0.DummyMock;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.impl.SendOtpValidationCreateChallengeV0Dao;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoInCreateChallengePost;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoOutCreateChallengePost;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SendOtpValidationCreateChallengeV0BusinessTest {

  @InjectMocks private SendOtpValidationCreateChallengeV0Business sendValidation;

  @Mock
  private SendOtpValidationCreateChallengeV0Dao dao;
  private DummyMock dummyMock;

  @Before
  public void init(){
    dummyMock = new DummyMock();
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testSendOtpValidationCreateChallengeV0() {
    sendValidation.sendOtpValidationCreateChallengeV0(dummyMock.getBDtoInCreateChallengePost());
  }
}
