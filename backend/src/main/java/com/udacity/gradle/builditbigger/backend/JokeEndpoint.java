/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.joker.Joker;

@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.builditbigger.gradle.udacity.com",
    ownerName = "backend.builditbigger.gradle.udacity.com",
    packagePath=""
  )
)
public class JokeEndpoint {

    @ApiMethod(name = "tellJoke")
    public JokeBean tellJoke() {
        JokeBean response = new JokeBean();
        Joker joker = new Joker();
        response.setText(joker.tell());
        return response;
    }
}
