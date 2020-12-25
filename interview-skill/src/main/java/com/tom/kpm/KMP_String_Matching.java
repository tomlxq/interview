package com.tom.kpm;

import lombok.extern.slf4j.Slf4j;

// JAVA program for implementation of KMP pattern
// searching algorithm
@Slf4j
public class KMP_String_Matching {
    void KMPSearch(String pat, String txt) {
        //被查找字符串的长度
        int M = pat.length();
        //查找字符串的长度
        int N = txt.length();

        // 创建将保留模式的最长前缀后缀值的lps []
        int lps[] = new int[M];
        //pat的索引[]
        int j = 0;
        //预处理模式（计算lps []数组）
        computeLPSArray(pat, M, lps);
log.info("{}",lps);
        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    /**
     * 预处理算法：
     * 在预处理部分，我们用lps []计算值。 为此，我们跟踪上一个索引的最长前缀后缀值的长度（为此，我们使用len变量）。 我们将lps [0]和len初始化为0。如果pat [len]和pat [i]匹配，我们将len加1，并将增加的值分配给lps [i]。 如果pat [i]和pat [len]不匹配且len不为0，则将len更新为lps [len-1]。 有关详细信息，请参见以下代码中的computeLPSArray（）。
     * <p>
     * 预处理图解（或构建lps []）
     *
     * @param pat
     * @param M
     * @param lps
     */
    void computeLPSArray(String pat, int M, int lps[]) {
        // 前一个最长前缀后缀的长度
        int len = 0;
        int i = 1;
        // lps [0]始终为0
        lps[0] = 0;

        // 循环为i = 1到M-1计算lps [i]
        while (i < M) {
            log.info("i {} len {}" ,pat.charAt(i),pat.charAt(len));
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }


}
// This code has been contributed by Amit Khandelwal.