# @robingenz/capacitor-badge

⚡️ Capacitor plugin to access and update the badge number of the app icon.

## Install

```bash
npm install @robingenz/capacitor-badge
npx cap sync
```

## API

<docgen-index>

* [`get()`](#get)
* [`set(...)`](#set)
* [`clear()`](#clear)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### get()

```typescript
get() => Promise<GetBadgeResult>
```

Get the badge count.
The badge count won't be lost after a reboot or app restart.

Default: `0`.

**Returns:** <code>Promise&lt;<a href="#getbadgeresult">GetBadgeResult</a>&gt;</code>

--------------------


### set(...)

```typescript
set(options: SetBadgeOptions) => Promise<void>
```

Set the badge count.

| Param         | Type                                                        |
| ------------- | ----------------------------------------------------------- |
| **`options`** | <code><a href="#setbadgeoptions">SetBadgeOptions</a></code> |

--------------------


### clear()

```typescript
clear() => Promise<void>
```

Clear the badge count.

--------------------


### Interfaces


#### GetBadgeResult

| Prop        | Type                |
| ----------- | ------------------- |
| **`count`** | <code>number</code> |


#### SetBadgeOptions

| Prop        | Type                |
| ----------- | ------------------- |
| **`count`** | <code>number</code> |

</docgen-api>
