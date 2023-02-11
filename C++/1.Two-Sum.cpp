/*
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        unordered_map<int, int> map;
        vector<int> answer;
        int difference = 0;
        for (int i = 0; i < nums.size(); ++i)
        {
            difference = target - nums[i];
            if (map.find(difference) != map.end())
            {
                answer.push_back(i);
                answer.push_back(map[difference]);
            }
            else
                map[nums[i]] = i;
        }
        return answer;
    }
};