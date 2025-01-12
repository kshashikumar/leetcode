class Solution
{
public:
    int lengthOfLongestSubstring(string s)
    {
        map<char, int> mp;
        if (s.length() == 1)
        {
            return 1;
        }

        int l = 0, r = 0, ans = 0;
        string sb;
        while (r < s.length())
        {
            cout << sb << endl;
            if (mp[s[r]] == 0)
            {
                sb = sb + s[r];
                mp[s[r]]++;
                r++;
            }
            else
            {
                if (sb.length() >= 1)
                {
                    sb = sb.substr(1, sb.length() - 1);
                }
                cout << sb << endl;
                mp[s[l]]--;
                l++;
            }
            if (sb.length() > ans)
            {
                ans = sb.length();
            }
        }
        return ans;
    }
};