class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        Car[] cars = new Car[N];

        for (int i = 0; i < N; i++) {
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(a.position, b.position));

        int ans = 1;    // There's at least one fleet
        for (int i = N - 2; i >= 0; i--) {
            // If cars[i] arrives later, it forms a new fleet
            if (cars[i].arrivalTime > cars[i + 1].arrivalTime) {
                ans += 1; 
            }
            // Otherwise cars[i] joins the existing fleet led by cars[i + 1]
            else {
                cars[i] = cars[i + 1];
            }
        }

        return ans;
    }
}

class Car {
    int position;
    double arrivalTime;
    Car(int p, double t) {
        position = p;
        arrivalTime = t;
    }
}