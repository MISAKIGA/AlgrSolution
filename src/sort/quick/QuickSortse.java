package sort.quick;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import testtool.TestTime;

public class QuickSortse {

	@Test
	public void runMainMethod() {
		
		TestTime.testTime(()->{
			quickSort(test);
		});
		
		System.out.println(Arrays.toString(test));
	}
	static int[] test = {1,23,4,5,6,7,8,9,4,2};
	void quickSort(int[] src) {
		if(src.length > 2) {
			quickSort(src,0,src.length -1);
		}
	}

	Random rand = new Random();
	public void quickSort(int[] src, int low, int high) {
        // 0����1��Ԫ�أ�����
        if (low >= high)
            return;
        // ���ѡ��key
        int i = low + rand.nextInt(high - low + 1);
        // ����key����˵�
        swap(src, low, i);
        // �����㷨����
        int key = src[low];
        int keyIndex = low;
        for (i = low + 1; i <= high; i++) {
            // С��key�ķŵ����
            if (src[i] < key) {
                swap(src, ++keyIndex, i);
            }
        }
        // ������˵��keyλ��
        swap(src, low, keyIndex);
        // �ݹ�������
        quickSort(src, low, keyIndex - 1);
        quickSort(src, keyIndex + 1, high);
    }

	
	private void swap(int[] src, int i, int j) {

		if(i < j) {
			int current = src[i];
			src[i] = src[j];
			src[j] = current;
		}
	}

	private void insertSort(int[] src) {

		
	}
}
