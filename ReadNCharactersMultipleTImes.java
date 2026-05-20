public class ReadNCharactersMultipleTImes extends Reader4 {

    private char[] tempBuffer = new char[4];
    private int tempBufferIndex = 0;
    private int charsToRead = 0;

    public int read(char[] buf, int n) {
    
        int index = 0;
        while(index < n) {
            if(tempBufferIndex == charsToRead) {
                tempBufferIndex = 0;
                charsToRead = read4(tempBuffer);
                if(charsToRead == 0) {
                    break;
                }
            }
        
            buf[index++] = tempBuffer[tempBufferIndex++];
        }
    
        return index;
    }
}
