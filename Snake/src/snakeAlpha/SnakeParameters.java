package snakeAlpha;

public class SnakeParameters {
		String SnakeColor = "Zielony";
		int Parts;
		int width;
		int height;
		int delay;
		SnakeParameters(String s, int P, int w, int h, int d){
			this.SnakeColor = s;
			this.Parts = P;
			this.width = w;
			this.height = h;
			this.delay = d;

		}
		
		public String GetSnakeColor() {
			return SnakeColor;
		}
		public void SetSnakeColor(String s) {
			this.SnakeColor = s;
		}
		public int GetParts() {
			return this.Parts;
		}
		public void SetParts(int p) {
			this.Parts = p;
		}
		public int GetWidth() {
			return this.width;
		}
		public void SetWidth(int p) {
			this.width = p;
		}
		public int GetHeight() {
			return this.height;
		}
		public void SetHeight(int p) {
			this.height = p;
		}
		public int GetDelay() {
			return this.delay;
		}
		public void SetDelay(int p) {
			this.delay = p;
		}
		
}
