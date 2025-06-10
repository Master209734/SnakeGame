package snakeAlpha;

public class SnakeParameters {
		String SnakeColor;
		int Parts;
		int width;
		int height;
		int delay;
		String Level;
		
		SnakeParameters(){
			this.SnakeColor = "Zielony";
			this.Parts = 5;
			this.width = 600;
			this.height = 600;
			this.delay = 80;
			this.Level = "Classic";
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
		public String GetLevel() {
			return Level;
		}
		public void SetLevel(String s) {
			this.Level = s;
		}
		
}
