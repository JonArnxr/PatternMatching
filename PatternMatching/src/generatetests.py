import argparse
import random

def generate_txt_file(num_entries):
    file_name = f"test{num_entries}.txt"
    with open(file_name, 'w') as file:
        file.write(f"{num_entries}\n")
        for _ in range(num_entries):
            x = random.randint(0, 32768)
            y = random.randint(0, 32768)
            file.write(f"{x} {y}\n")

def main():
    parser = argparse.ArgumentParser(description='Generate a text file with random numbers.')
    parser.add_argument('num_entries', type=int, help='Number of entries in the generated text file')
    args = parser.parse_args()
    num_entries = args.num_entries
    generate_txt_file(num_entries)

if __name__ == "__main__":
    main()
