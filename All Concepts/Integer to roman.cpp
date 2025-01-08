class Solution
{
public:
    string intToRoman(int num)
    {
        map<int, string, greater<int>> mp;
        mp[1] = "I";
        mp[4] = "IV";
        mp[5] = "V";
        mp[9] = "IX";
        mp[10] = "X";
        mp[40] = "XL";
        mp[50] = "L";
        mp[90] = "XC";
        mp[100] = "C";
        mp[400] = "CD";
        mp[500] = "D";
        mp[900] = "CM";
        mp[1000] = "M";

        string ans = "";

        for (auto e : mp)
        {
            if (num == 0)
            {
                break;
            }
            else
            {
                while (num >= e.first)
                {
                    num = num - e.first;
                    ans = ans + e.second;
                }
            }
        }
        return ans;
    }
};