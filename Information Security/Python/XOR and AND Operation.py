s = "Hello World"

print(f"{'Char':^6} {'ASCII':^8} {'&127':^8} {'^127':^8}")
print("-" * 32)

for c in s:
    original = ord(c)
    and_val = original & 127
    xor_val = original ^ 127
    print(f"{c:^6} {original:^8} {and_val:^8} {xor_val:^8}")
