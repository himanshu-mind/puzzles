import java.util.LinkedList;
import java.util.Queue;

public class SwapNodes {

	static class Node {
		int value;
		Node left, right;

		Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {

		int[][] a = new int[11][2];

		a[0] = new int[] { 2, 3 };
		a[1] = new int[] { 4, -1 };
		a[2] = new int[] { 5, -1 };
		a[3] = new int[] { 6, -1 };
		a[4] = new int[] { 7, 8 };
		a[5] = new int[] { -1, 9 };
		a[6] = new int[] { -1, -1 };
		a[7] = new int[] { 10, 11 };
		a[8] = new int[] { -1, -1 };
		a[9] = new int[] { -1, -1 };
		a[10] = new int[] { -1, -1 };

		int[] q = new int[] { 2, 4 };

		swapNodes(a, q);

	}

	static void swapNodes(int[][] indexes, int[] queries) {
		Node root = new Node(1);

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		for (int i = 0; i < indexes.length; i++) {
			Node node = queue.peek();

			if (indexes[i][0] > 0) {
				node.left = new Node(indexes[i][0]);
				queue.add(node.left);
			}

			if (indexes[i][1] > 0) {
				node.right = new Node(indexes[i][1]);
				queue.add(node.right);
			}

			queue.remove();
		}

		for (int i = 0; i < queries.length; i++) {
			swap(root, 1, queries[i]);
			builder = new StringBuilder();
			inOrder(root);
			System.out.println(builder.toString().trim());
		}

	}

	static void swap(Node parent, int level, int k) {
		if (parent == null)
			return;

		if (level % k == 0) {
			Node temp = parent.left;
			parent.left = parent.right;
			parent.right = temp;
		}

		swap(parent.left, level + 1, k);
		swap(parent.right, level + 1, k);
	}

	private static StringBuilder builder = new StringBuilder();

	static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			builder.append(root.value).append(" ");
			// System.out.print(root.value + " ");
			inOrder(root.right);
		}
	}

}
