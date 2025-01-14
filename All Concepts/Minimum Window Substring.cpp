class Solution
{
public:
    string minWindow(string s, string t)
    {
        if (t.size() == 0 || s.size() == 0)
            return "";

        int tFreq[128] = {0};
        for (char c : t)
        {
            tFreq[c]++;
        }

        int wFreq[128] = {0};
        int l = 0, r = 0;
        int minL = INT_MAX, sI = 0;
        int req = t.size();

        while (r < s.size())
        {
            char ch = s[r];
            wFreq[ch]++;

            if (tFreq[ch] > 0 && wFreq[ch] <= tFreq[ch])
            {
                req--;
            }

            while (req == 0)
            {
                if (r - l + 1 < minL)
                {
                    minL = r - l + 1;
                    sI = l;
                }

                char lc = s[l];
                wFreq[lc]--;
                if (tFreq[lc] > 0 && wFreq[lc] < tFreq[lc])
                {
                    req++;
                }
                l++;
            }

            r++;
        }

        return minL == INT_MAX ? "" : s.substr(sI, minL);
    }
};