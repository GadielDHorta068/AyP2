package binarySearch;

public class BinarySearch {

	public static boolean recursivo(int[] data, int target, int low, int high) {
		if (low > high) {
			return false;
		}

		else {
			int mid = (low + high) / 2;
			if (target == data[mid]) {
				return true;
			} else if (target < data[mid]) {
				return recursivo(data, target, low, mid - 1);
			}

			else {
				return recursivo(data, target, mid + 1, high);
			}

		}
	}

	public static boolean iterativo(int[] data, int target) {
		int low = 0;
		int high = data.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (data[mid] == target) {
				return true;
			} else if (data[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}
}
