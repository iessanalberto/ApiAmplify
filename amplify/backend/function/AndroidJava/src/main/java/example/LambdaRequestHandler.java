

package example;

import com.amazonaws.services.lambda.runtime.Context; 
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaRequestHandler implements RequestHandler<Object, String>{

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);

        String output = "" + input + "";
        // TODO: implement your handler
        return output;
    }

    /*
    public ResponseClass handleRequest(RequestClass request, Context context){
        String greetingString = String.format("Hello %s %s!", request.firstName, request.lastName);
        return new ResponseClass(greetingString);
    }
    */

    //TODO https://www.youtube.com/watch?v=gBWLeq13hy8

}