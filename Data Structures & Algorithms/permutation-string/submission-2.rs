use crate::hash_map::Entry;

impl Solution {
    // iterate s2
    // sliding window of size of s1
    // maintain count of each char in the window
    pub fn check_inclusion(s1: String, s2: String) -> bool {
        let wsize = s1.len();
        if s2.len() < wsize { return false; }
        let mut target = HashMap::new();
        let mut curr = HashMap::new();

        for c in s1.chars() {
            let count = target.entry(c).or_insert(0);
            *count += 1; 
        }

        // initial window
        for c in s2[0..wsize].chars() {
            let count = curr.entry(c).or_insert(0);
            *count += 1;
        }

        let mut start = 0;

        while start + wsize <= s2.len() {
            // check if target == curr
            let mut eq = true;
            // println!("{:?}", curr);
            for (c, tcount) in &target {
                match curr.get(c) {
                    Some(count) => eq &= count == tcount,
                    None => eq = false
                }
                if !eq { break; }
            }
            if eq { return true; }
            if start + wsize == s2.len() { return false; }

            let leaving = s2.chars().nth(start).unwrap();
            let coming = s2.chars().nth(start + wsize).unwrap();
            if let Entry::Occupied(mut entry) = curr.entry(leaving) {
                *entry.get_mut() -= 1;
                if *entry.get() == 0 {
                    entry.remove();
                }
            }
            *curr.entry(coming).or_insert(0) += 1;
            start += 1;
        }

        false
    }
}
