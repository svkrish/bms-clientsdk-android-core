/*
 *     Copyright 2015 IBM Corp.
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.ibm.mobilefirstplatform.clientsdk.android.security.mca.internal.security;


import android.test.InstrumentationTestCase;

import com.ibm.mobilefirstplatform.clientsdk.android.security.identity.BaseAppIdentity;
import com.ibm.mobilefirstplatform.clientsdk.android.security.identity.BaseDeviceIdentity;
import com.ibm.mobilefirstplatform.clientsdk.android.security.mca.api.MCAAuthorizationManager;

import org.json.JSONObject;

public class AuthorizationManagerTests extends InstrumentationTestCase {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		MCAAuthorizationManager.createInstance(getInstrumentation().getTargetContext());
	}

	public void testDefaultAppIdentity() throws Exception {

		JSONObject appIdentity = (BaseAppIdentity)MCAAuthorizationManager.getInstance().getAppIdentity();

		assertNotNull(appIdentity.getString("version"));
		assertNotNull(appIdentity.getString("id"));
	}

	public void testDefaultDeviceIdentity() throws Exception {

		JSONObject deviceIdentity = (BaseDeviceIdentity)MCAAuthorizationManager.getInstance().getDeviceIdentity();

		assertNotNull(deviceIdentity.get("id"));
		assertNotNull(deviceIdentity.get("platform"));
		assertNotNull(deviceIdentity.get("model"));
	}
}