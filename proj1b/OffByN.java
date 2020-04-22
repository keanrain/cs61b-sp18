public class OffByN implements CharacterComparator {
    static int N = 0;
    
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == N;
    }
    
    public OffByN(int n) {
        N = n;
    }
}
