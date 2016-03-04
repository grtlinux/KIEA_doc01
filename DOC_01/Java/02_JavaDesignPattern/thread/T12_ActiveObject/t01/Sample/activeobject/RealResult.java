package kiea.priv.zzz.book.JavaDesignPattern.thread.T12_ActiveObject.t01.Sample.activeobject;



class RealResult extends Result {
    private final Object resultValue;
    public RealResult(Object resultValue) {
        this.resultValue = resultValue;
    }
    public Object getResultValue() {
        return resultValue;
    }
}
