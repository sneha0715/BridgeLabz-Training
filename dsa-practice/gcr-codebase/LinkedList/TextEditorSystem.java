class TextState {
    String content;
    TextState next;
    TextState prev;

    TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    TextState head;
    TextState tail;
    TextState current;
    int size;
    int limit;

    TextEditor(int limit) {
        this.limit = limit;
        this.size = 0;
    }

    void addState(String text) {
        TextState state = new TextState(text);

        if (head == null) {
            head = tail = current = state;
            size = 1;
            return;
        }

        if (current != tail) {
            current.next = null;
            tail = current;
            size = countNodes();
        }

        tail.next = state;
        state.prev = tail;
        tail = state;
        current = state;
        size++;

        if (size > limit) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Undo not possible");
        }
    }

    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Redo not possible");
        }
    }

    void displayCurrentState() {
        if (current == null) {
            System.out.println("No text available");
            return;
        }
        System.out.println("Current Text: " + current.content);
    }

    int countNodes() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class TextEditorSystem {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("Hello Java");
        editor.displayCurrentState();
    }
}
