package callback;

interface CallBack {
  void methodToCallBack();
}

class CallBackImpl implements CallBack {
  public void methodToCallBack() {
    System.out.println("I've been called back");
  }
}

public class CallbackDemo {

  public void register(CallBack callback) {
    callback.methodToCallBack();
  }

  public static void main(String[] args) {
    CallbackDemo caller = new CallbackDemo();
    CallBack callBack = new CallBackImpl();
    caller.register(callBack);
  }
}